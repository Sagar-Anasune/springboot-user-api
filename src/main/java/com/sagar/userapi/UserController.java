@PutMapping("/{id}")
public User updateUser(@PathVariable Long id, @RequestBody User user) {
    User existingUser = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

    existingUser.setName(user.getName());
    return repo.save(existingUser);
}

@DeleteMapping("/{id}")
public String deleteUser(@PathVariable Long id) {
    repo.deleteById(id);
    return "User deleted successfully";
}