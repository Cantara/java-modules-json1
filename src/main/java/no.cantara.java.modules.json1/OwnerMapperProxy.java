package no.cantara.java.modules.json1;

import no.cantara.java.modules.json1.mapper.OwnerMapperJackson1;

public class OwnerMapperProxy implements OwnerMapper {

    private OwnerMapperJackson1 ownerMapper;

    public OwnerMapperProxy() {
       ownerMapper = new OwnerMapperJackson1();
    }

    @Override
    public String toJson(Owner owner) {
        return ownerMapper.toJson(owner);
    }
}
