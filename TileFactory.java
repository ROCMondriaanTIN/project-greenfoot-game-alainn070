
/**
 *
 * @author R. Springer
 */
public class TileFactory {

    /**
     * Creates a Tile object based on the mapIcon number you give
     *
     * @param mapIcon number
     * @return Tile tile object
     */
    public static Tile createTile(int mapIcon) {
        Tile tile;
        switch (mapIcon) {
            case 5:
                tile = new Tile("box.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 6:
                tile = new Tile("boxAlt.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 7:
                tile = new Tile("boxCoin.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 12:
                tile = new Tile("boxExplosive.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 15:
                tile = new Tile("boxItem.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 22:
                tile = new Tile("bridgeLogs.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.getImage().mirrorVertically();
                tile.isSolid = true;
                break;
            case 110:
                tile = new Tile("grassCenter.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
               case 264:
                tile = new Tile("sandCenter.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 126:
                tile = new Tile("grassLeft.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 127:
                tile = new Tile("grassMid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 128:
                tile = new Tile("grassRight.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 116:
                tile = new Tile("grassHalf.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break; 
            case 326:
                tile = new Tile("stoneHalf.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 295:
                tile = new Tile("snowCenter.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;    
            case 175:
                tile = new WaterTile("liquidWater.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 177:
                tile = new Tile("liquidWaterTop_mid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 284:
                tile = new Tile("signExit.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 285:
                tile = new Tile("signLeft.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 82:
                tile = new Door("door_openMid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT,TileType.DOOR_OPENMID);
                break;
            case 83:
                tile = new Tile("door_openTop.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 286:
                tile = new Tile("signRight.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 40:
                tile = new Tile("castleHalf.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break; 
            case 56:
                tile = new Tile("cloud3.png", TileEngine.TILE_WIDTH,TileEngine.TILE_HEIGHT);             
                break;
            case 160:
                tile = new Tile("hud_p1Alt.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 159:
                tile = new Tile("hud_p1.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break; 
            case 162:
                tile = new Tile("hud_p2Alt.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = false;
                tile.getImage().scale(50, 50);
                break;
            case 134:
            tile = new Tile("hud_1.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = false;
            break;
            case 135:
            tile = new Tile("hud_2.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = false;
            break;
            case 136:
            tile = new Tile("hud_3.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = false;
            break;
            case 137:
            tile = new Tile("hud_4.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = false;
            break;
            case 164:
            tile = new Tile("hud_p3Alt.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = false;
            tile.getImage().scale(50, 50);
            break;    
            case 174:
                tile = new Tile("liquidLavaTop_mid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 172:
                tile = new LavaTile("liquidLava.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 58:
                tile = new Tile("coinGold.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break; 
            case 57:
                tile = new Tile("coinBronze.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;    
            case 131:
                tile = new Tile("hill_small.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 129:
                tile = new Tile("hill_large.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                break;
            case 167:
                tile = new Tile("keyGreen.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = false;
                break;
            case 178:
                tile = new Tile("lock_blue.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 166:
                tile = new Tile("keyBlue.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = false;
                break;
            case 180:
                tile = new Tile("lock_red.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
            case 168:
                tile = new Tile("keyRed.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = false;
                break;
            case 105:
                tile = new Tile("gemBlue.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = false;
                break;
            case 318:
                tile = new Tile("star.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = false;
                break;
            case 179:
                tile = new Tile("lock_green.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;    
            default:
                tile = new Tile("sandMid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
                tile.isSolid = true;
                break;
        }
        return tile;
    }
}
