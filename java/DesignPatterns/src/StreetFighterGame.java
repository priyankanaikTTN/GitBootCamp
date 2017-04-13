/**
 * Created by priyanka on 12/4/17.
 */

abstract  class PlayerMoves
{
    RollMove rollMove;
    JumpMove jumpMove;

    public PlayerMoves(RollMove rollMove, JumpMove jumpMove) {
        this.rollMove = rollMove;
        this.jumpMove = jumpMove;
    }

    public void kick(){
        System.out.println("Kicking high");
    }

    public void punch(){

        System.out.println("Punching hard");
    }

}

interface  RollMove
{

    public void roll();
}



class RollMoveSlow implements RollMove
{

    @Override
    public void roll() {
        System.out.println("Rolling slowly");

    }
}

class RollMoveFast implements RollMove
{

    @Override
    public void roll() {

        System.out.println("Rolling fast");

    }
}


interface JumpMove
{
    public void jump();
}

class JumpMoveHigh implements JumpMove
{
    @Override
    public void jump() {

        System.out.println("Jump high");
    }
}

class JumpMoveLow implements JumpMove
{
    @Override
    public void jump() {

        System.out.println("Jump low");
    }
}

class PlayerGirl extends PlayerMoves
{

    public PlayerGirl(RollMove rollMove, JumpMove jumpMove) {
        super(rollMove, jumpMove);
    }


}

class PlayerBoy extends PlayerMoves
{

    public PlayerBoy(RollMove rollMove, JumpMove jumpMove) {
        super(rollMove, jumpMove);
    }
}

public class StreetFighterGame {


    public static void main(String[] args) {


        PlayerGirl playerGirl= new PlayerGirl(new RollMoveFast(),new JumpMoveHigh());

        System.out.println("Player Girl moves:");

        playerGirl.kick();
        playerGirl.punch();
        playerGirl.rollMove.roll();
        playerGirl.jumpMove.jump();
        System.out.println("**********************************");

        System.out.println("Player Girl moves Changed:");
         playerGirl= new PlayerGirl(new RollMoveSlow(),new JumpMoveLow());
         playerGirl.punch();
         playerGirl.kick();
         playerGirl.rollMove.roll();
         playerGirl.jumpMove.jump();

    }




}
