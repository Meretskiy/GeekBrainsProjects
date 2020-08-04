package ru.meretskiy.homework16.server;

import java.util.ArrayList;
import java.util.List;

public class BaseAuthService implements AuthService {

    private class Entry {
        private String login;
        private String pass;
        private String nick;

        public Entry(String login, String pass, String nick) {
            this.login = login;
            this.pass = pass;
            this.nick = nick;
        }

        public String getLogin() {
            return login;
        }

        public String getPass() {
            return pass;
        }

        public String getNick() {
            return nick;
        }
    }

    private List<Entry> entries;

    @Override
    public void start() {
        System.out.println("Service of authentication is start...");
    }

    @Override
    public void stop() {
        System.out.println("Service of authentication is stop...");
    }

    public BaseAuthService() {
        entries = new ArrayList<>();
        entries.add(new Entry("login1", "pass1", "nick1"));
        entries.add(new Entry("login2", "pass2", "nick2"));
        entries.add(new Entry("login3", "pass3", "nick3"));
    }

    @Override
    public String getNickByLoginPass(String login, String pass) {
        for (Entry o : entries) {
            if (o.getLogin().equals(login) && o.getPass().equals(pass)) {
                return o.getNick();
            }
        }
        return null;
    }
}
