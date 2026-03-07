import http from 'k6/http';
import { check, sleep } from 'k6';
import { randomItem } from 'https://jslib.k6.io/k6-utils/1.2.0/index.js';

export let options = {
    stages: [
        { duration: '1m', target: 10 }, // simulate ramp-up of traffic from 1 to 10 users over 1 minute.
        { duration: '30m', target: 10 }, // stay at 10 users for 2 minutes
        { duration: '1m', target: 0 },  // ramp-down to 0 users
    ],
    thresholds: {
        'http_req_duration': ['p(99)<1500'], // 99% of requests must complete below 1.5s
    },
};

const BASE_URL = 'http://localhost:8080/api/carts';

// List of SKUs representing egg-based products
const productSKUs = [
    'EGGWHITEPACK', 'ORGANICBROWN', 'FREERANGE', 'OMEGARICH', 'HARDBOILED',
    'LIQUIDEGG', 'EGGYOLKONLY', 'POACHED', 'SCRAMBLEDMIX', 'MINIEGGS',
    'DEVILEDEGGS', 'EGGSALAD', 'EGGWHITES', 'QUAILEGGS', 'DUCKEGGS',
    'CAGEFREE', 'PICKLEDEGGS', 'EGGBITES', 'SPICEDEGGS', 'EGGSANDWICH'
];

export default function () {
    // Create a new cart
    let res = http.post(`${BASE_URL}`);
    check(res, { 'created cart': (r) => r.status === 200 });
    let cartId = res.json('id'); // assuming the response contains the cart ID

    let randomSKU = randomItem(productSKUs);

    // Add an item to the cart
    let addItemRes = http.post(`${BASE_URL}/${cartId}/items`, { sku: randomSKU, quantity: '1' }, { headers: { 'Content-Type': 'application/x-www-form-urlencoded' } });
    check(addItemRes, { 'added item': (r) => r.status === 200 });

    // Get the cart contents
    let getCartRes = http.get(`${BASE_URL}/${cartId}`);
    check(getCartRes, { 'retrieved cart': (r) => r.status === 200 });

    // Optionally delete an item from the cart
    // Replace itemId with an actual item ID
    // let deleteItemRes = http.del(`${BASE_URL}/${cartId}/items/itemId`);
    // check(deleteItemRes, { 'deleted item': (r) => r.status === 200 });

    // Optionally delete the cart
    // let deleteCartRes = http.del(`${BASE_URL}/${cartId}`);
    // check(deleteCartRes, { 'deleted cart': (r) => r.status === 200 });

    sleep(1);
}
