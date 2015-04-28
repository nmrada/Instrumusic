/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.general.util.Log4JConfiguration;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Nicolas
 */
public class AbstractDAO {

    public AbstractDAO() {
        PropertyConfigurator.configure(Log4JConfiguration.PROPERTIES); 
    }
    
}
