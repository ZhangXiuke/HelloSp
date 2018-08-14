package com.zxk.aop;


/*@Aspect    //该标签把LoggerAspect类声明为一个切面
@Order(1)  //设置切面的优先级：如果有多个切面，可通过设置优先级控制切面的执行顺序（数值越小，优先级越高）
@Component*/ //该标签把LoggerAspect类放到IOC容器中
public class LoggerAspect {

	/*@Pointcut("execution(public * com.zxk.controller.*Controller.*(..))")
    public void declearJoinPointExpression(){}

	
	@Before("declearJoinPointExpression()") //该标签声明次方法是一个前置通知：在目标方法开始之前执行
    public void beforMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("this method "+methodName+" begin. param<"+ args+">");
    }*/
}
