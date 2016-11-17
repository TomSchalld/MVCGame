package com.schalldach.thomas.game.controler;

import com.schalldach.thomas.game.model.Model;
/**
 * Created by remy on 17/11/16.
 */
public interface IGameModelVisitor {
    public void visit(Model model);
}