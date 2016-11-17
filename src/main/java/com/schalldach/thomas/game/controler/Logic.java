package com.schalldach.thomas.game.controler;

import com.schalldach.thomas.game.model.Model;
import com.schalldach.thomas.game.view.MainWindow;

/**
 * Created by B.Sc. Thomas Schalldach on 22/10/2016. The code of this application is free to use for non-commercial projects,
 * as long as you ensure that you credit the author. For commercial usage, please contact software[at]thomas-schalldach.de
 */
public class Logic {

    private MainWindow view;
    private Model model;
    private static Logic instance;
    private static Object lock = new Object();


    public MainWindow getView() {
        return view;
    }

    public void setView(MainWindow view) {
        this.view = view;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public static Logic getInstance() {
        if (instance ==null){
            synchronized (lock){
                if (instance ==null){
                    instance = new Logic();
                }
            }
        }
        return instance;
    }

    private Logic() {
    }
}
