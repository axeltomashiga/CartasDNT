package uno

class Usuario {

    String nombre
    String apellido
    String email
    String contrasenia
    int edad
    BigDecimal saldo

    static constraints = {
        nombre size: 1..15, nullable: false, unique: true
        apellido size: 1..15, nullable: false
        email email: true, nullable: false
        contrasenia password: true, nullable: false
        edad min: 18, nullable: false
        saldo nullable: false
    }
}
