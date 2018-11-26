### Description

Unfortunately Boot does not have sophisticated method clear the cache.

How to evict cache?
- Manually

- By scheduling
According to the doc method annotated by `@Scheduled` must has no-args and has a void as declared type
```
@Scheduled(fixedRate = 10 * 1000)
public void clearCache() {
    //clear you cache here
}
```