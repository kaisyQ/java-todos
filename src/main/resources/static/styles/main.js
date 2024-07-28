
/**
 * Todo придумать как создавать компненты
 * @param {HTMLFormElement} form 
 * @param {Event} event
 */
async function sendRequestByFormData (form, event) {

    event.preventDefault();

    const inputData = {};
    
    /** @type {HTMLCollection} */
    const inputs = [...form.getElementsByTagName('input'), ...form.getElementsByTagName('textarea')];

    Array.from(inputs).map(
        /** @param {HTMLInputElement} input */
        input => {
        inputData[input.name] =  input.value;
    });


    console.log(inputData)

    const response = await fetch(form.action, {
        method: form.method,
        headers: {
            'Content-type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(inputData)
    });

    console.log(response);

    const data = await response.json();

    console.log(data);

}