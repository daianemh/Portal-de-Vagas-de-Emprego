@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
    List<Vaga> findByEmpresaId(Long empresaId);
}
