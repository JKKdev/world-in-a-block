package com.github.jkkdev.wiab.core.handler;

import com.github.jkkdev.wiab.core.util.LocalizationUtil;
import com.github.jkkdev.wiab.lib.Localization;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LocalizationHandler {

    public static void loadLanguages() {

        for (String localizationFile : Localization.langFiles) {
            LanguageRegistry.instance().loadLocalization(localizationFile, LocalizationUtil.getLocaleFromFileName(localizationFile), LocalizationUtil.isXMLLanguageFile(localizationFile));
        }
    }
    
}
