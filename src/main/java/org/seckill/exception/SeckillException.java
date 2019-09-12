package org.seckill.exception;

/**
 * 秒杀相关异常
 * @author tank
 * @Date 2019/8/17 - 18:57
 */
public class SeckillException extends RuntimeException{


    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
