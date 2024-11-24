package org.aey.common.utils.nanoid.strategies;

import org.aey.common.utils.nanoid.NanoId;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;

public class NanoIdGenerator implements IdentifierGenerator, Configurable {

    @Override
    public Object generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        return NanoId.randomNanoId();
    }
}
