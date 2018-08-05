package org.fanlychie.common.filter;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.dianping.cat.Cat;
import com.dianping.cat.CatConstants;
import com.dianping.cat.message.Transaction;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

import static com.dianping.cat.Cat.Context;

/**
 * Created by fanlychie on 2018/7/28.
 */
public class DubboCatFilter implements Filter {

    private static final String ERROR = "-1";

    private static final String CONSUMER = "consumer";

    private static final String PROVIDER = "provider";

    private static final Gson GSON = new GsonBuilder()
            .serializeNulls()
            .disableHtmlEscaping()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Result result = null;
        String methodSignature = buildMethodName(invoker, invocation) + buildMethodArguments(invocation);
        Transaction transaction = Cat.newTransaction(CatConstants.TYPE_SERVICE, methodSignature);
        String side = invoker.getUrl().getParameter("side");
        switch (side) {
            case CONSUMER:
                CatContext context = new CatContext();
                Cat.logRemoteCallClient(context);
                setRpcContextAttachment(context);
                break;
            case PROVIDER:
                Cat.logRemoteCallServer(createCatContext(invocation));
                break;
        }
        try {
            result = invoker.invoke(invocation);
            transaction.setStatus(Transaction.SUCCESS);
        } catch (Exception e) {
            transaction.setStatus(ERROR);
            Cat.logError(e);
        } finally {
            transaction.complete();
        }
        return result;
    }

    private void setRpcContextAttachment(Context context) {
        RpcContext.getContext().setAttachment(Context.PARENT, context.getProperty(Context.PARENT));
        RpcContext.getContext().setAttachment(Context.CHILD, context.getProperty(Context.CHILD));
        RpcContext.getContext().setAttachment(Context.ROOT, context.getProperty(Context.ROOT));
    }

    private CatContext createCatContext(Invocation invocation) {
        CatContext context = new CatContext();
        context.addProperty(Context.ROOT, invocation.getAttachment(Context.ROOT));
        context.addProperty(Context.PARENT, invocation.getAttachment(Context.PARENT));
        context.addProperty(Context.CHILD, invocation.getAttachment(Context.CHILD));
        return context;
    }

    private String buildMethodName(Invoker<?> invoker, Invocation invocation) {
        StringBuilder methodNameBuilder = new StringBuilder();
        methodNameBuilder.append(invoker.getInterface().getName()).append(".").append(invocation.getMethodName());
        return methodNameBuilder.toString();
    }

    private String buildMethodArguments(Invocation invocation) {
        StringBuilder methodArgumentsBuilder = new StringBuilder("(");
        Object[] args = invocation.getArguments();
        if (args != null && args.length > 0) {
            for (Object arg : args) {
                methodArgumentsBuilder.append(GSON.toJson(arg)).append(", ");
            }
            int length = methodArgumentsBuilder.length();
            methodArgumentsBuilder = methodArgumentsBuilder.replace(length - 2, length, "");
        }
        return methodArgumentsBuilder.append(")").toString();
    }

    /**
     * Created by fanlychie on 2018/7/28.
     */
    static class CatContext implements Context {

        private Map<String, String> map = new HashMap<>();

        @Override
        public void addProperty(String key, String value) {
            map.put(key, value);
        }

        @Override
        public String getProperty(String key) {
            return map.get(key);
        }

    }

}