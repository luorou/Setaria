
import * as _ref_Li9za2lrby5tanM_ from './skiko.mjs';
import { instantiate } from './routers.uninstantiated.mjs';

const exports = (await instantiate({
    './skiko.mjs': _ref_Li9za2lrby5tanM_
})).exports;

export default new Proxy(exports, {
    _shownError: false,
    get(target, prop) {
        if (!this._shownError) {
            this._shownError = true;
            if (typeof console !== "undefined") {
                console.error("Do not use default import. Use corresponding named import instead.")
            }
        }
        return target[prop];
    }
});
export const {
    _initialize,
    memory
} = exports;

