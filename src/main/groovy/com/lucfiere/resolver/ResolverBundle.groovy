package com.lucfiere.resolver

import com.lucfiere.file.SourceCodeBundle
import com.lucfiere.resolver.type.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ResolverBundle {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResolverBundle.class)

    private List<Resolver> resolvers

    List<Resolver> resolvers() { resolvers }

    void add(Resolver resolver) {
        resolvers << resolver
    }

    void replace(List<Resolver> resolvers) {
        this.resolvers = resolvers
    }

    ResolverBundle() {
        this.resolvers = ResolverFactory.defaultResolvers()
    }

    void resolve(SourceCodeBundle bundle, BootstrapContext context) {
        bundle.setEntityName(context.getTable().entityName)
        resolvers.each {
            if (it instanceof DaoResolver) {
                it.resolve(context)
                bundle.setDaoContent(it.result())
                LOGGER.info(it.result())
            }
            if (it instanceof MapperResolver) {
                it.resolve(context)
                bundle.setMapperContent(it.result())
                LOGGER.info(it.result())
            }
            if (it instanceof PojoResolver) {
                it.resolve(context)
                bundle.setPojoContent(it.result())
                LOGGER.info(it.result())
            }
            if (it instanceof CriteriaResolver) {
                it.resolve(context)
                bundle.setCriteriaContent(it.result())
                LOGGER.info(it.result())
            }
            if (it instanceof DaoImplResolver) {
                it.resolve(context)
                bundle.setDaoImplContent(it.result())
                LOGGER.info(it.result())
            }
            if (it instanceof MapperXMLResolver) {
                it.resolve(context)
                bundle.setMapperXmlContent(it.result())
                LOGGER.info(it.result())
            }
            if (it instanceof ServiceResolver) {
                it.resolve(context)
                bundle.setServiceContent(it.result())
                LOGGER.info(it.result())
            }
            if (it instanceof ServiceImplResolver) {
                it.resolve(context)
                bundle.setServiceImplContent(it.result())
                LOGGER.info(it.result())
            }
        }
    }

}
