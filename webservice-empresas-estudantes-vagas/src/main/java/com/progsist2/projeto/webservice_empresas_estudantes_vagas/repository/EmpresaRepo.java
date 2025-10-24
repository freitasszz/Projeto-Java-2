package com.progsist2.projeto.webservice_empresas_estudantes_vagas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.progsist2.projeto.webservice_empresas_estudantes_vagas.model.Empresa;

public interface EmpresaRepo extends JpaRepository<Empresa, Long> {
}

