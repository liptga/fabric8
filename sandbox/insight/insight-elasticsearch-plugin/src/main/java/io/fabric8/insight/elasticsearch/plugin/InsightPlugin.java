package io.fabric8.insight.elasticsearch.plugin;

import org.elasticsearch.common.collect.Lists;
import org.elasticsearch.common.component.LifecycleComponent;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.plugins.AbstractPlugin;

import java.util.Collection;

public class InsightPlugin extends AbstractPlugin {

    private final Settings settings;

    public InsightPlugin(Settings settings) {
        this.settings = settings;
    }

    @Override
    public String name() {
        return "fabric8-insight";
    }

    @Override
    public String description() {
        return "Manages Insight indices, performing configurable housekeeping of data";
    }

    @Override
    public Collection<Class<? extends LifecycleComponent>> services() {
        Collection<Class<? extends LifecycleComponent>> services = Lists.newArrayList();
        services.add(InsightIndicesHousekeeperService.class);
        return services;
    }
}
