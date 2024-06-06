CREATE TABLE public.tasks (
    id UUID DEFAULT random_uuid() NOT NULL,
    name VARCHAR(200) NOT NULL,
    description VARCHAR(200),
    status VARCHAR(200) NOT NULL,
    due_time TIMESTAMP,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW(),
    category_id UUID NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);
