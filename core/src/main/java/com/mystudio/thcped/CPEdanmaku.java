package com.mystudio.thcped;

import java.util.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.graphics.Graphics;

public class CPEdanmaku extends BasicGame {
	public static final String GAME_IDENTIFIER = "com.mystudio.thcped";

  private Texture gamebg;
  private int screenWidth, screenHeight;
  private Player player;
  private Boss boss;
  private KeyInput keyInput;
  public static CollisionHandler ch;
  
  //public static Set<Bullet> pBullet;
  //public static Set<Bullet> EnemyBullet;
  //public Iterator<Bullet> itpb;

	@Override
    public void initialise() {
      gamebg = new Texture("roombg3.png");
      this.player = new Player(40,300,2);
      this.boss = new Boss(40, 40, 5);
      this.keyInput = new KeyInput(this.player);
      ch = new CollisionHandler(player, boss);
      //pBullet = new HashSet<>();
      //EnemyBullet = new HashSet<>();
      //itpb = pBullet.iterator();
    }
    
    @Override
    public void update(float delta) {
      Gdx.input.setInputProcessor(this.keyInput);
      player.update(delta);
    }
    
    @Override
    public void interpolate(float alpha) {
    player.interpolate(alpha);
    }
    
    @Override
    public void render(Graphics g) {
    g.drawTexture(gamebg, 0f, 0f);
    player.render(g);
    boss.render(g);
    
    }
}
