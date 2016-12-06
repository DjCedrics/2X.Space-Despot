/**
 * 
 */
package space_despot.Game_Screen_Elements;

/**
 * Bullet
 *
 * @author djcedrics
 * @date Dec 6, 2016
 */
public class Bullet extends SpaceObject{
	
	// Constants
	// Properties
	protected int attackDamage;
	// Constructor
	public Bullet(int attackDamage)
	{
		this.attackDamage = attackDamage;
	}
	// Methods
	public int getAttackDamage()
	{
		return attackDamage;
	}
	
	public void setAttackDamage(int attackDamage)
	{
		this.attackDamage = attackDamage;
	}

}
