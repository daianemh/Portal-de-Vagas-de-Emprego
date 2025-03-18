@Service
public class VagaService {
    private final VagaRepository vagaRepository;

    public VagaService(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    public List<Vaga> listarTodas() {
        return vagaRepository.findAll();
    }

    public Optional<Vaga> buscarPorId(Long id) {
        return vagaRepository.findById(id);
    }

    public Vaga salvar(Vaga vaga) {
        return vagaRepository.save(vaga);
    }
    public Vaga aplicarCandidato(Long vagaId, Long candidatoId) {
        Optional<Vaga> vaga = vagaRepository.findById(vagaId);
        if (vaga.isPresent()) {
            Vaga vagaAtual = vaga.get();
            // Aqui você pode buscar o candidato e adicionar à vaga
            Candidato candidato = candidatoRepository.findById(candidatoId)
                    .orElseThrow(() -> new RuntimeException("Candidato não encontrado"));

            vagaAtual.getCandidatos().add(candidato);
            return vagaRepository.save(vagaAtual);
        }
        throw new RuntimeException("Vaga não encontrada");
    }

    public void excluir(Long id) {
        vagaRepository.deleteById(id);
    }

    public List<Vaga> buscarPorEmpresa(Long empresaId) {
        return vagaRepository.findByEmpresaId(empresaId);
    }
}
