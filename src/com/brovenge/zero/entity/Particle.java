package com.brovenge.zero.entity;

import com.brovenge.zero.graphics.Render;
import com.brovenge.zero.graphics.Sprite;

public class Particle extends Entity {

	private Sprite sprite;

	private int life;
	private int time = 0;

	protected double xx, yy, zz;
	protected double xa, ya, za;

	public Particle(int x, int y, int life) {
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;
		this.life = life + (random.nextInt(20) - 10);
		sprite = Sprite.particle_test;

		this.xa = random.nextGaussian() + 1.8;
		if (this.xa < 0) xa = 0.1;
		this.ya = random.nextGaussian();
		this.zz = random.nextFloat() + 2.0;
	}

	public void update() {
		time++;
		if (time >= 7400) time = 0;
		if (time > life) remove();
		za -= 0.1;

		if (zz < 0) {
			zz = 0;
			za *= -0.55;
			xa *= 0.1;
			ya *= 0.4;
		}

		this.xx = xa;
		this.yy = ya;
		this.zz = za;
	}

	public void render(Render render) {
		render.renderSprite((int) xx + 6, (int) yy - (int) zz, sprite, true);
	}

}
