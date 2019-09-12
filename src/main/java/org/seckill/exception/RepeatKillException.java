package org.seckill.exception;

import org.springframework.test.annotation.Repeat;
import sun.awt.CausedFocusEvent;

/**
 * 重复秒杀异常（运行期异常）
 * @author tank
 * @Date 2019/8/17 - 18:54
 */
public class RepeatKillException extends SeckillException{

    public RepeatKillException(String message) {
        super(message);
    }


    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }


}
