package com.which.whichapp.repository;

import com.which.whichapp.domain.Smartphone;
import com.which.whichapp.domain.enumeration.EnumMarca;
import com.which.whichapp.domain.enumeration.EnumOS;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

@Repository
public class SmartphoneCriteriaRepository{
    @PersistenceContext
    EntityManager entityManager;

    protected Session currentSession() {
        return entityManager.unwrap(Session.class);
    }

    public List<Smartphone> buscarSmartphonesByFiltros(Map<String, Object> parametros) {

        Criteria smartphoneDefinitionCriteria = currentSession().createCriteria(Smartphone.class);
        smartphoneDefinitionCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);



        filtroBySo(parametros, smartphoneDefinitionCriteria);
        filtroByMarca(parametros, smartphoneDefinitionCriteria);
        filtroByCamara(parametros, smartphoneDefinitionCriteria);
        filtroByFrontCamara(parametros, smartphoneDefinitionCriteria);
        filtroByRom(parametros, smartphoneDefinitionCriteria);

        List<Smartphone>  resultados = smartphoneDefinitionCriteria.list();

        return resultados;
    }

    private void filtroBySo(Map<String, Object> parametros, Criteria smartphoneDefinitionCriteria) {
        if (parametros.containsKey("sos")) {
            String[] sos = (String[]) parametros.get("sos");
            smartphoneDefinitionCriteria.add(Restrictions.in("so", sos));
        }
    }
    private void filtroByMarca(Map<String, Object> parametros, Criteria smartphoneDefinitionCriteria) {
        if (parametros.containsKey("marcas")) {
            String[] marcas = (String[]) parametros.get("marcas");
            smartphoneDefinitionCriteria.add(Restrictions.in("marca", marcas));
        }
    }
    private void filtroByCamara(Map<String, Object> parametros, Criteria smartphoneDefinitionCriteria) {
        if (parametros.containsKey("camaras")) {
            Integer[] camaras = (Integer[]) parametros.get("camaras");
            smartphoneDefinitionCriteria.add(Restrictions.in("camara", camaras));
        }
    }
    private void filtroByFrontCamara(Map<String, Object> parametros, Criteria smartphoneDefinitionCriteria) {
        if (parametros.containsKey("front_camaras")) {
            Integer[] front_camaras = (Integer[]) parametros.get("front_camaras");
            smartphoneDefinitionCriteria.add(Restrictions.in("front_camara", front_camaras));
        }
    }
    private void filtroByRom(Map<String, Object> parametros, Criteria smartphoneDefinitionCriteria) {
        if (parametros.containsKey("roms")) {
            Integer[] roms = (Integer[]) parametros.get("roms");
            smartphoneDefinitionCriteria.add(Restrictions.in("rom", roms));
        }
    }
}
