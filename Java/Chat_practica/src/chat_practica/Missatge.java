package chat_practica;

public class Missatge {
    String dniOrigen;
    String dniDesti;
    String text;

    public Missatge(String dniOrigen, String dniDesti, String text) {
        this.dniOrigen = dniOrigen;
        this.dniDesti = dniDesti;
        this.text = text;
    }
    
    public String getDniOrigen() {
        return dniOrigen;
    }

    public void setDniOrigen(String dniOrigen) {
        this.dniOrigen = dniOrigen;
    }

    public String getDniDesti() {
        return dniDesti;
    }

    public void setDniDesti(String dniDesti) {
        this.dniDesti = dniDesti;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
