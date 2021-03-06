/**
 * 
 */
package space_despot.Game_Screen_Elements;

import javax.swing.ImageIcon;

import space_despot.Constants.Constants;


public class Boss extends SpaceMob {

	// CONSTANTS
	private final ImageIcon BOSS_ICON_1 = new ImageIcon("resources/images/boss_level1.png");
	private final ImageIcon BOSS_ICON_2 = new ImageIcon("resources/images/boss_level2.png");
	private final ImageIcon BOSS_ICON_3 = new ImageIcon("resources/images/boss_level3.png");
	 
	// CONSTRUCTOR
	public Boss(int level) {
		super(level);
		maxHP = level * Constants.BOSS_INITIAL_MAX_HP;
		HP = maxHP;
		attackDamage = level * Constants.BOSS_ATTACK_DAMAGE;
		if ( level == 1 )
		{
			image = BOSS_ICON_1.getImage();
		}
		else if ( level == 2 )
		{
			image = BOSS_ICON_2.getImage();
		}		
		else
		{
			image = BOSS_ICON_3.getImage();
		}
		width = image.getWidth(null);
		height = image.getHeight(null);	
		velocityX = level * Constants.BOSS_VELOCITY;
		velocityY = level * Constants.BOSS_VELOCITY;
		x = Constants.SPACE_WIDTH / 2 - width / 2; // initially at middle
		y = 0; // initially at top.
		hasCoin = false;
		hasPowerUp = false;
		isGoingLeft = false;
	}
	
	// METHODS
	@Override
	public void move() {
		if (x < (Constants.SPACE_WIDTH - width - 2) && x > (Constants.SPACE_WIDTH - width - 10)) {
			velocityX = - level * Constants.BOSS_VELOCITY;
		}	
		if (x > 2 && x < 10) {
			velocityX = level * Constants.BOSS_VELOCITY;
		}
		
		// 2 is special to image width, it should be even number
		if (y < (Constants.SPACE_HEIGHT - height - 2) && y >(Constants.SPACE_HEIGHT - height - 10)) {
			velocityY = - level * Constants.BOSS_VELOCITY;
		}		
		if (y > 2 && y < 10) {
			velocityY = level * Constants.BOSS_VELOCITY;
		}
		
		x = x + velocityX;
		y = y + velocityY;
		

	}
	
	// shoot bullet
	public BossBullet shoot() {
	    // create the new bullet
		BossBullet bullet = new BossBullet(attackDamage);
	    
	    // bullet's initial coordinate will be boss' barrel coordinate
	    bullet.setX(x + width / 2 - bullet.getWidth() / 2);
	    bullet.setY(y + height);
	    
	    return bullet;
	}
}