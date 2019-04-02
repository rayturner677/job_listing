CREATE TABLE IF NOT EXISTS employers(
    id  SERIAL PRIMARY KEY,
    name         TEXT,
    address      TEXT,
    position     TEXT,
    description  TEXT,
    benefits     TEXT,
    email        TEXT,
    logo_url     TEXT
);

CREATE TABLE IF NOT EXISTS comments(
    id                SERIAL,
    comment_body      TEXT,
    employer_id      INTEGER REFERENCES employers(id) ON DELETE CASCADE
);

GRANT ALL ON TABLE employers TO "user";
GRANT ALL ON TABLE comments TO "user";
GRANT ALL PRIVILEGES ON SEQUENCE comments_id_seq TO "user";
GRANT ALL PRIVILEGES  ON SEQUENCE employers_id_seq TO  "user";