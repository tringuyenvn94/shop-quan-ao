/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpSessionEvent ;
    import javax.servlet.http.HttpSessionListener ;
    import javax.servlet.http.HttpSession ;
    import java.util.List ;
    import java.util.ArrayList ;

/**
 *
 * @author luctanbinh
 */

    public class SessionCounter implements HttpSessionListener {

        private List sessions = new ArrayList();

        public SessionCounter() {
        }

        public void sessionCreated(HttpSessionEvent event) {
            HttpSession session = event.getSession();
            sessions.add(session.getId());

            session.setAttribute("counter", this);
        }

        public void sessionDestroyed(HttpSessionEvent event) {
            HttpSession session = event.getSession();
            sessions.remove(session.getId());

            session.setAttribute("counter", this);
        }

        public int getActiveSessionNumber() {
            return sessions.size();
        }
    }

