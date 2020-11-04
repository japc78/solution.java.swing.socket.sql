package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.views.Message;
import usantatecla.tictactoe.models.Error;
import usantatecla.utils.Console;

class PlayView {

    private Game game;

    PlayView(Game game) {
        this.game = game;
    }

    void interact() {
        do {
            if (!this.game.isBoardComplete()) {
                this.put();
            } else {
                this.move();
            }
            new GameView(this.game).write();
        } while (!this.game.isTicTacToe());
        new TokenView(this.game.getToken()).write();
        Console.getInstance().writeln(Message.PLAYER_WIN.toString());
    }

    private void put() {
        boolean isUser = this.game.isUser();
        Coordinate coordinate;
        Error error;
        do {
            if (isUser) {
                coordinate = new CoordinateView()
                    .read(Message.COORDINATE_TO_PUT.toString());
            } else {
                coordinate = new Coordinate();
                coordinate.random();
            }
            error = this.game.put(coordinate);
            if (isUser) {
                new ErrorView(error).writeln();
            }
        } while (!error.isNull());
    }

    private void move() {
        boolean isUser = this.game.isUser();
        Coordinate origin;
        Coordinate target;
        Error error;
        do {
            if (isUser) {
                origin = new CoordinateView()
                .read(Message.COORDINATE_TO_REMOVE.toString());
                target = new CoordinateView()
                .read(Message.COORDINATE_TO_MOVE.toString());
            } else {
                origin = new Coordinate();
                origin.random();
                target = new Coordinate();
                target.random();
            }
            error = this.game.move(origin, target);
            if (isUser) {
                new ErrorView(error).writeln();
            }
        } while (!error.isNull());
    }

}