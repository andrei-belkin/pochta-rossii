package ru.andreibelkin.pochtarossii.repository;

import ru.andreibelkin.pochtarossii.entity.MailPost;

import java.util.Optional;

public class MailPostRepository implements EntityRepository<MailPost> {
    @Override
    public MailPost save(MailPost mailPost) {
        return mailPost;
    }

    @Override
    public MailPost update(MailPost mailPost) {
        return mailPost;
    }

    @Override
    public Optional<MailPost> findById(int entityId) {
        return Optional.empty();
    }

    @Override
    public void deleteById(MailPost mailPost) {

    }
}
