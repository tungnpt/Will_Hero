public class OnIsland {
    public static boolean checkOnIsland(Player player, FloatingIsland floatingIsland){
        if((player.position.x>=floatingIsland.position.x
                && player.position.x+25<=floatingIsland.position.x+floatingIsland.width
                && player.position.y+player.height+player.velocity.y>=floatingIsland.position.y
        )
                || (player.position.x+player.width-25>=floatingIsland.position.x
                && player.position.x+player.width<=floatingIsland.position.x+floatingIsland.width
                && player.position.y+player.height+player.velocity.y>=floatingIsland.position.y
        ) ){
            return true;
        }
        return false;
    }
}
