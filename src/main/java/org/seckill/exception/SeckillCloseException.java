package org.seckill.exception;

/**
 * 秒杀关闭异常（）
 * @author tank
 * @Date 2019/8/17 - 18:56
 */
public class SeckillCloseException extends SeckillException{

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
