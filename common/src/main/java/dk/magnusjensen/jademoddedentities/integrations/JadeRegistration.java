package dk.magnusjensen.jademoddedentities.integrations;

import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;

public interface JadeRegistration {
    void initClient(IWailaClientRegistration registration);

    void init(IWailaCommonRegistration registration);
}
