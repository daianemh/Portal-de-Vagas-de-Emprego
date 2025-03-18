@RestController
@RequestMapping("/vagas")
public class VagaController {
    private final VagaService vagaService;

    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }

    // Lista todas as vagas
    @GetMapping
    public List<Vaga> listarTodas() {
        return vagaService.listarTodas();
    }

    // Busca uma vaga pelo ID
    @GetMapping("/{id}")
    public Optional<Vaga> buscarPorId(@PathVariable Long id) {
        return vagaService.buscarPorId(id);
    }
    @PutMapping("/{vagaId}/candidatos/{candidatoId}")
    public Vaga aplicarCandidato(@PathVariable Long vagaId, @PathVariable Long candidatoId) {
        return vagaService.aplicarCandidato(vagaId, candidatoId);
    }


    // Cria uma nova vaga
    @PostMapping
    public Vaga criarVaga(@RequestBody Vaga vaga) {
        return vagaService.salvar(vaga);
    }

    // Exclui uma vaga pelo ID
    @DeleteMapping("/{id}")
    public void excluirVaga(@PathVariable Long id) {
        vagaService.excluir(id);
    }

    // Busca vagas de uma empresa específica
    @GetMapping("/empresa/{empresaId}")
    public List<Vaga> buscarPorEmpresa(@PathVariable Long empresaId) {
        return vagaService.buscarPorEmpresa(empresaId);
    }
}
