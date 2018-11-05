package com.lucfiere.resolver

import com.lucfiere.resolver.appender.StandardCriteriaResolver
import com.lucfiere.resolver.appender.StandardDaoResolver
import com.lucfiere.resolver.appender.StandardMapperResolver
import com.lucfiere.resolver.appender.StandardPojoResolver

class ResolverFactory {

    static List<Resolver> defaultResolvers() {
        [
                new StandardPojoResolver(),
                new StandardDaoResolver(),
                new StandardMapperResolver(),
                new StandardCriteriaResolver()
        ]
    }

}
