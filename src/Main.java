import model.repository.AlunoRepository;
import model.repository.OficinaRepository;
import view.View;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        AlunoRepository alunoRepository = new AlunoRepository();
        OficinaRepository oficinaRepository = new OficinaRepository();

        View view = new View();
    }
}