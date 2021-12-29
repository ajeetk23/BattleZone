//public class Contact
//{
//    GamePiece one;
//    GamePiece two;
//    Location l;
//    public Contact(GamePiece one, GamePiece two)
//    {
//        this.one = one;
//        this.two = two;
//        if(one.getLocation().equals( two.getLocation() ))
//        {
//          this.l = one.getLocation();
//          one.setContact( this );
//          two.setContact( this );
//        }
//        else
//        {
//            throw new NullPointerException("Contact cannot be created - Pieces are not at same Location");
//        }
//    }
//    public Piece getFirstPiece()
//    {
//        return one;
//    }
//    public Piece getSecondPiece()
//    {
//        return two;
//    }
//    public Location getLocation()
//    {
//        return l;
//    }
//    public void contactDamage()
//    {
//       if (two.getPieceType() == PieceType.TWO)
//       {
//         two.setAttack(1);
//       }
//       one.reduceHealth(two.getAttack());
//       two.reduceHealth(one.getAttack());
//       one.setContact(this);
//       two.setContact(this);
//    }
//    public void contactAttack()
//    {
//       one.reduceHealth(two.getAttack());
//       two.reduceHealth(one.getAttack());
//    }
//}