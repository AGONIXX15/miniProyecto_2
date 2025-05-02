package models.pokemon.utils;

/**
 * @author Simon Tarazona
 */
public class Attack {
    private String name;          // Nombre del ataque
    private short power;            // Poder del ataque
    private TypeDamage typeDamage; // Tipo de daño (FISICO o ESPECIAL)




    /**
     * Constructor para inicializar un ataque con nombre, poder y tipo de daño.
     *
     * @param name       Nombre del ataque.
     * @param power      Poder del ataque.
     * @param typeDamage Tipo de daño (FÍSICO o ESPECIAL).
     */
    public Attack(String name, short power, TypeDamage typeDamage) {
        this.name = name;
        this.power = power;
        this.typeDamage = typeDamage;

    }

    //ataques predefinidos
    public static final Attack THUNDERBOLT = new Attack("Rayo", (short)40,TypeDamage.ESPECIAL);
    public static final Attack FIRE_BLAST = new Attack("Llamarada", (short) 60, TypeDamage.ESPECIAL);
    public static final Attack FLAMETHROWER = new Attack("Lanzallamas", (short) 50, TypeDamage.ESPECIAL);
    public static final Attack WATER_GUN = new Attack("Pistola de Agua", (short) 35, TypeDamage.ESPECIAL);
    public static final Attack THUNDER = new Attack("Trueno", (short) 60, TypeDamage.ESPECIAL);
    public static final Attack RAZOR_LEAF = new Attack("Hoja Afilada", (short) 40, TypeDamage.FISICO);
    public static final Attack VINE_WHIP = new Attack("Látigo Cepa", (short) 30, TypeDamage.FISICO);
    public static final Attack SOLAR_BEAM = new Attack("Rayo Solar", (short) 65, TypeDamage.ESPECIAL);
    public static final Attack TACKLE = new Attack("Placaje", (short) 20, TypeDamage.FISICO);
    public static final Attack DOUBLE_KICK = new Attack("Doble Patada", (short) 30, TypeDamage.FISICO);
    public static final Attack SHOCK_WAVE = new Attack("Onda Trueno", (short) 35, TypeDamage.ESPECIAL);
    public static final Attack QUICK_ATTACK = new Attack("Ataque Rápido", (short) 30, TypeDamage.FISICO);
    public static final Attack LEAF_BLADE = new Attack("Cuchilla de Hoja", (short) 45, TypeDamage.FISICO);
    public static final Attack SLASH = new Attack("Cuchillada", (short) 40, TypeDamage.FISICO);


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getPower() {
        return power;
    }

    public void setPower(short power) {
        this.power = power;
    }

    public TypeDamage getTypeDamage() {
        return typeDamage;
    }

    public void setTypeDamage(TypeDamage typeDamage) {
        this.typeDamage = typeDamage;
    }

    @Override
    public String toString() {
        return name + " (" + power + " de poder, tipo: " + typeDamage + ")";
    }


    public void showInfo() {
        System.out.println("Ataque: " + name);
        System.out.println("Poder: " + power);
        System.out.println("Tipo de Daño: " + typeDamage);

    }
}

