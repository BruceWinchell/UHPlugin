/*
 * Plugin UHCReloaded : Alliances
 *
 * Copyright ou © ou Copr. Amaury Carrade (2016)
 * Idées et réflexions : Alexandre Prokopowicz, Amaury Carrade, "Vayan".
 *
 * Ce logiciel est régi par la licence CeCILL soumise au droit français et
 * respectant les principes de diffusion des logiciels libres. Vous pouvez
 * utiliser, modifier et/ou redistribuer ce programme sous les conditions
 * de la licence CeCILL telle que diffusée par le CEA, le CNRS et l'INRIA
 * sur le site "http://www.cecill.info".
 *
 * En contrepartie de l'accessibilité au code source et des droits de copie,
 * de modification et de redistribution accordés par cette licence, il n'est
 * offert aux utilisateurs qu'une garantie limitée.  Pour les mêmes raisons,
 * seule une responsabilité restreinte pèse sur l'auteur du programme,  le
 * titulaire des droits patrimoniaux et les concédants successifs.
 *
 * A cet égard  l'attention de l'utilisateur est attirée sur les risques
 * associés au chargement,  à l'utilisation,  à la modification et/ou au
 * développement et à la reproduction du logiciel par l'utilisateur étant
 * donné sa spécificité de logiciel libre, qui peut le rendre complexe à
 * manipuler et qui le réserve donc à des développeurs et des professionnels
 * avertis possédant  des  connaissances  informatiques approfondies.  Les
 * utilisateurs sont donc invités à charger  et  tester  l'adéquation  du
 * logiciel à leurs besoins dans des conditions permettant d'assurer la
 * sécurité de leurs systèmes et ou de leurs données et, plus généralement,
 * à l'utiliser et l'exploiter dans les mêmes conditions de sécurité.
 *
 * Le fait que vous puissiez accéder à cet en-tête signifie que vous avez
 * pris connaissance de la licence CeCILL, et que vous en avez accepté les
 * termes.
 */
package eu.carrade.amaury.UHCReloaded.core;

import fr.zcraft.zlib.core.ZLib;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class ModuleLogger extends Logger
{
    private final String loggerName;

    ModuleLogger(Class<?extends UHModule> module)
    {
        super(ZLib.getPlugin().getClass().getCanonicalName(), null);

        setParent(ZLib.getPlugin().getLogger());
        setLevel(Level.ALL);

        loggerName = "[" + ZLib.getPlugin().getName() + "] [" + ModuleWrapper.computeModuleName(module) + " Module] ";
    }

    @Override
    public void log(LogRecord logRecord)
    {
        logRecord.setMessage(loggerName + logRecord.getMessage());
        super.log(logRecord);
    }

    public void log(Level level, String message, Throwable ex, Object... args)
    {
        log(level, message, args);
        log(level, "Exception : ", ex);
    }

    public void info(String message, Object...args)
    {
        log(Level.INFO, message, args);
    }

    public void warning(String message, Object... args)
    {
        log(Level.WARNING, message, args);
    }

    public void warning(String message, Throwable ex)
    {
        log(Level.WARNING, message, ex);
    }

    public void warning(String message, Throwable ex, Object... args)
    {
        log(Level.WARNING, message, ex, args);
    }

    public void error(String message)
    {
        log(Level.SEVERE, message);
    }

    public void error(String message, Throwable ex)
    {
        log(Level.SEVERE, message, ex);
    }

    public void error(String message, Throwable ex, Object... args)
    {
        log(Level.SEVERE, message, ex, args);
    }

    public void error(String message, Object... args)
    {
        log(Level.SEVERE, message, args);
    }
}