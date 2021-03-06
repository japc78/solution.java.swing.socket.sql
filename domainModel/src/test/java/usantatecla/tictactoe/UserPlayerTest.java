package usantatecla.tictactoe;


import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserPlayerTest {
    private Board board;
    private UserPlayer player;
    private Coordinate coordinate00;
    private Coordinate coordinate01;

    public UserPlayerTest() {
        this.board = new Board();
        this.player = new UserPlayer(Token.O, this.board);
        this.coordinate00 = new Coordinate(0, 0);
        this.coordinate01 = new Coordinate(0, 1);
    }

    @Test
    public void testGivenNewUserPlayerWhenPutNewTokenThenReturnErrorNotEmpty() {
        this.board.put(this.coordinate00, Token.O);
        assertThat(this.player.checkPutCoordinateError(this.coordinate00), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenNewUserPlayerWhenPutNewTokenThenNotReturnErrorNull() {
        this.board.put(this.coordinate00, Token.O);
        assertThat(this.player.checkPutCoordinateError(new Coordinate(0, 2)) == Error.NULL, is(true));
    }

    @Test
    public void testGivenNewUserPlayerWhenRemoveTokenThenReturnErrorNotOwner() {
        this.board.put(this.coordinate00, Token.O);
        assertThat(this.player.checkMoveOriginCoordinateError(this.coordinate01), is(Error.NOT_OWNER));
    }

    @Test
    public void testGivenNewUserPlayerWhenRemoveTokenThenNotReturnErrorNull() {
        this.board.put(this.coordinate00, Token.O);
        assertThat(this.player.checkMoveOriginCoordinateError(this.coordinate00) == Error.NULL, is(true));
    }

    @Test
    public void testGivenNewUserPlayerWhenMoveTokenThenReturnErrorSameCoordinates() {
        this.board.put(this.coordinate00, Token.O);
        assertThat(this.player.checkMoveTargetCoordinateError(this.coordinate00, this.coordinate00), is(Error.SAME_COORDINATES));
    }

    @Test
    public void testGivenNewUserPlayerWhenMoveTokenThenReturnErrorNotEmpty() {
        this.board.put(this.coordinate00, Token.O);
        this.board.put(this.coordinate01, Token.O);
        assertThat(this.player.checkMoveTargetCoordinateError(this.coordinate00, this.coordinate01), is(Error.NOT_EMPTY));
    }

    @Test
    public void testGivenNewUserPlayerWhenMoveTokenThenNotReturnErrorNull() {
        this.board.put(this.coordinate00, Token.O);
        assertThat(this.player.checkMoveTargetCoordinateError(this.coordinate00, this.coordinate01) == Error.NULL, is(true));
    }
}
