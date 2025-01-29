package cat.paucasesnovescifp.spaad;

import cat.paucasesnovescifp.spaad.controlErrors.JPAException;
import cat.paucasesnovescifp.spaad.model.Aspirant;
import cat.paucasesnovescifp.spaad.proves.Persistencia;
import java.util.List;


public class ExamenRecuperacio {

    public static void main(String[] args) throws JPAException {
        
        Persistencia p = new Persistencia("interins");
        //Aquest es simplement per comprobar que funcina
//        System.out.println(p.tornaAspirant("23797769F"));

        List<Aspirant> asp = p.llistaAspirants();
        
        for(Aspirant a : asp){
            System.out.println(a);
        }
        
        System.out.println(p.preferenciesAspirantNQ());
    }
    
}
