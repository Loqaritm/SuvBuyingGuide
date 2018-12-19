package com.drools.example;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.drools.compiler.compiler.DroolsParserException;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import javax.swing.*;
import java.io.IOException;

public class SuvBuyingGuide {

	private static JFrame frame;

	public static void main(String[] args) throws DroolsParserException, IOException {
		SuvBuyingGuide suvBuyingGuide = new SuvBuyingGuide();
		suvBuyingGuide.executeHelloWorldRules();
	}

	public void executeHelloWorldRules() throws IOException, DroolsParserException {
		KieServices ks = KieServices.Factory.get();
		BasicConfigurator.configure();

		Logger.getLogger(SuvBuyingGuide.class).setLevel(Level.OFF);
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession session = kContainer.newKieSession("ksession-rules");

		session.setGlobal("frame", frame);
		session.fireAllRules();
	}
}
