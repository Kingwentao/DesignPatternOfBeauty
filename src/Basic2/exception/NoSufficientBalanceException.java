package Basic2.exception;

/**
 * author: WentaoKing
 * created on: 2019/12/2
 * description:
 */
public class NoSufficientBalanceException extends Exception{

    public NoSufficientBalanceException(String detailMessage){
        super(detailMessage);
    }
}
