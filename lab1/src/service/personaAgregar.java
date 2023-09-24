import model.Persona;
import util.CSVRecord;
import util.FileOperations;
import util.JsonParser;
import util.compression.Compression;
import util.compression.huffman.HuffmanNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class personaAgregar {
    private List<Persona> list;
    private String path;
    private Compression<Persona> compression;
    private JsonParser parser;

    public PersonaService(String path, Compression compression) {
        this.path = path;
        list = new ArrayList<>();
        parser = new JsonParser();
        this.compression = compression;
    }

    public void loadPersonas() {
        FileOperations operations = new FileOperations();

        List<CSVRecord> datos = operations.reader(path);

        datos.forEach((record) -> {
            if (record.getOperation().equals("INSERT")) {
                Persona persona = parser.getPersona(record.getJson());
                // aplicando logica del negocio, presentar nombres de autores en mayuscula
                persona.setName(persona.getName().toUpperCase());
                Persona compressed = compression.comprimir(persona, Persona.class);
                //tree.insert(persona);
                list.add(compressed);
            }
        });
    }

    public Persona findByName(String name) {
        // return tree.findByName(name.toUpperCase());
        Persona personaCompressed = list.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst().get();
        System.out.println(personaCompressed.getName());
        if (personaCompressed.getCompanies() instanceof HashMap) {
            HashMap<String, HuffmanNode> map = (HashMap<String, HuffmanNode>) personaCompressed.getCompanies();
            for (String entry : map.keySet()) {
                System.out.println(entry);
            }
        }

        if (personaCompressed.getCompanies() instanceof List) {
            List<List<Integer>> list = (List<List<Integer>>) personaCompressed.getCompanies();
            for (List<Integer> entry : list) {
                System.out.println(entry);
            }
        }

        return compression.descomprimir(personaCompressed, Persona.class);
    }

    public void printPersona(Persona p) {
        List<String> lista = (List<String>) p.getCompanies();
        for (int i = 0; i < lista.size(); i++) {
            lista.set(i, lista.get(i).split(" ")[1]);
        }
        parser.showPersona(p);
    }
}