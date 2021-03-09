package ikab.checkers.views.console;


import ikab.checkers.controllers.PlayController;

class PlayView {

    void interact(PlayController playController) {
        new PlayMenu(playController).execute();
        new GameView(playController).write();
    }

}
