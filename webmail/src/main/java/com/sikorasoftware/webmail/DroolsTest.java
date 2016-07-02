package com.sikorasoftware.webmail;


import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;

/**
 * Created by robertsikora on 19.02.2016.
 */
public class DroolsTest {

    //public final static void main(String... args) throws Exception {
    //    KnowledgeBase kbase = readKnowledgeBase();
    //    StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
    //    ksession.fireAllRules();
    //}

    private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("bpmn-tasks/test.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            errors.forEach(System.err::println);
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }
}
