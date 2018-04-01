package concurrent;

import java.util.Set;

/**
 * @author dreamyao
 * @title
 * @date 2018/3/31 下午7:46
 * @since 1.0.0
 */
public interface Puzzle<P,M> {
    P initialPosition();

    boolean isGoal(P position);

    Set<M> legalMoves(P position);

    P move(P position, M move);
}
