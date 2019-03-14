CREATE TABLE IF NOT EXISTS employers(
    id  SERIAL PRIMARY KEY,
    name    TEXT,
    address TEXT,
    position TEXT,
    description TEXT,
    benefits    TEXT,
    email   TEXT,
    logo_url    TEXT
)

CREATE TABLE IF NOT EXISTS comments(
    id SERIAL
    name        TEXT,
    address TEXT,
    position    TEXT,
    description    TEXT,
    benefits   TEXT,
    comment_info    Text,
    employer_id REFERENCES employer(id)
)